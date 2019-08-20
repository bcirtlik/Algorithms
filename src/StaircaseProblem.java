public class StaircaseProblem {


    int counter=0;

    public void findWayToClimb(int n){

        findWayToClimb(0,n);
        System.out.println(counter);

    }

    public void findWayToClimb(int totalStepCount,int n){


        if(n-totalStepCount>=1){
            findWayToClimb(totalStepCount+1,n);
        }

        if(n-totalStepCount>=2){
            findWayToClimb(totalStepCount+2,n);
        }
        if(n-totalStepCount<=0){
            counter++;
            return;
        }
    }

    public static void main(String[] args) {
        StaircaseProblem staircaseProblem=new StaircaseProblem();
        staircaseProblem.findWayToClimb(2);
    }



}

