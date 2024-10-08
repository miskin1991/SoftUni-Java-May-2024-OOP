package Exercise.Polymorphism.word;

public class PasteTransform implements TextTransform {
    CutTransform cutTransform;

    public PasteTransform(CutTransform cutTransform) {
        this.cutTransform = cutTransform;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, cutTransform.getCutText());
    }
}
