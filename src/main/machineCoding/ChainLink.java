package main.machineCoding;

/*
    Check which side of loop is longer
    If both are equal
        return NONE
        else LEFT or RIGHT
 */

public class ChainLink {

    enum Side { NONE, LEFT, RIGHT }

    private ChainLink left, right;

    public void append(ChainLink rightPart) {

        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {

        ChainLink current = this;
        ChainLink temp = current;
        int leftCount = 0;
        int rightCount = 0;

        if(checkForLoop(current)){
            return Side.NONE;
        }

        while (temp != null){
            leftCount++;
            temp = temp.left;
        }

        temp = current;
        while(temp != null){
            rightCount++;
            temp = temp.right;
        }

        if(leftCount == rightCount){
            return Side.NONE;
        } else if(leftCount < rightCount){
            return Side.RIGHT;
        } else {
            return Side.LEFT;
        }
    }

    private boolean checkForLoop(ChainLink current) {

        ChainLink slow = current;
        ChainLink fast = current;
        while(slow != null && fast != null && fast.right != null){
            slow = slow.right;
            fast = fast.right.right;
            if(slow == fast){
                return true;
            }
        }

        slow = current;
        fast = current;
        while(slow != null && fast != null && fast.left != null){
            slow = slow.left;
            fast = fast.left.left;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);

        System.out.println(left.longerSide());
    }
}
