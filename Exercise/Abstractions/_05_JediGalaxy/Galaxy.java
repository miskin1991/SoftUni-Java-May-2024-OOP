package Exercise.Abstractions._05_JediGalaxy;

public class Galaxy {
    private int[][] matrix;
    private long score;

    public long getScore() {
        return score;
    }

    public Galaxy(int x, int y) {
        this.matrix = initialiseGalaxy(x, y);
        this.score = 0;
    }

    private int[][] initialiseGalaxy(int x, int y) {
        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }

    public void play(Evil evil) {
        while (evil.getX() >= 0 && evil.getY() >= 0)
        {
            if (evil.getX() >= 0 && evil.getX() < matrix.length && evil.getY() >= 0 && evil.getY() < matrix[0].length)
            {
                matrix[evil.getX()] [evil.getY()] = 0;
            }
            evil.move();
        }
    }

    public void play(Player player) {
        while (player.getX() >= 0 && player.getY() < matrix[1].length)
        {
            if (player.getX() >= 0 && player.getX() < matrix.length
                    && player.getY() >= 0 && player.getY() < matrix[0].length)
            {
                score += matrix[player.getX()][player.getY()];
            }
            player.move();
        }
    }
}
