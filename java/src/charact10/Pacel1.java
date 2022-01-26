package charact10;

public class Pacel1 {
    class Contents {
        private int i = 1;
        public int value(){return i;}
    }
    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){return label;}

    }
}
