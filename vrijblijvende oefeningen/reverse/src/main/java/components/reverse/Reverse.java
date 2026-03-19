package components.reverse;

public class Reverse {
    private String text;

    public Reverse(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void reverseText(){
        StringBuilder sb = new StringBuilder(this.text);
        this.text = sb.reverse().toString();
    }
}
