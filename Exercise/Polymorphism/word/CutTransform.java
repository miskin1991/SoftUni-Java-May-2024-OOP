package Exercise.Polymorphism.word;

class CutTransform implements TextTransform {

    private String cutText;

    public String getCutText() {
        return cutText;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        cutText = text.substring(startIndex, endIndex);
        text.delete(startIndex, endIndex);
    }
}