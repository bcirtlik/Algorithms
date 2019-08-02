public class PickTwoSongs {


    public PickTwoSongs(int rideDuration,int[] songDurations) {

        int totalDuration=rideDuration-30;

        int start=0;
        int end=songDurations.length-1;

        while (start!=end){

            int total= songDurations[end]+songDurations[start];

            if(total<totalDuration){
                start++;
            }else if(total>totalDuration){
                end--;
            }else{
                System.out.println("Picked Two Song:"+songDurations[start]+" , "+ songDurations[end]);
                break;
            }
        }

        if(start==end){
            System.out.println("Cannot Pick");
        }

    }
}
