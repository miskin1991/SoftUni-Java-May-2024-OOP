package Exercise.Encapsulation.Pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setWeight(weight);
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
    }

    private void setWeight(double weight) {
        if (weight >= 1.0 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy")
                || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    double calculateCalories() {
        double coefficientFlour = 0.0;
        switch (flourType) {
            case "White" -> coefficientFlour = 1.5;
            case "Wholegrain" -> coefficientFlour = 1.0;
        }
        double coefficientBaking = 0.0;
        switch (bakingTechnique) {
            case "Crispy" -> coefficientBaking = 0.9;
            case "Chewy" -> coefficientBaking = 1.1;
            case "Homemade" -> coefficientBaking = 1.0;
        }

        return (2 * weight) * coefficientFlour * coefficientBaking;
    }
}
