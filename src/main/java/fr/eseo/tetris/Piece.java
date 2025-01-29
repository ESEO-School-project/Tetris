package fr.eseo.tetris;

public class Piece {
    enum Tetromino {
        I, O, T, L, J, S, Z
    }
    
    class Piece {
        private Tetromino type;
        private int[][] shape;
    
        public Piece(Tetromino type) {
            this.type = type;
            this.shape = getShape(type);
        }
    
        private int[][] getShape(Tetromino type) {
            switch (type) {
                case I:
                    return new int[][] {
                        {0, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}
                    };
                case O:
                    return new int[][] {
                        {1, 1},
                        {1, 1}
                    };
                case T:
                    return new int[][] {
                        {0, 1, 0},
                        {1, 1, 1},
                        {0, 0, 0}
                    };
                case L:
                    return new int[][] {
                        {0, 0, 1},
                        {1, 1, 1},
                        {0, 0, 0}
                    };
                case J:
                    return new int[][] {
                        {1, 0, 0},
                        {1, 1, 1},
                        {0, 0, 0}
                    };
                case S:
                    return new int[][] {
                        {0, 1, 1},
                        {1, 1, 0},
                        {0, 0, 0}
                    };
                case Z:
                    return new int[][] {
                        {1, 1, 0},
                        {0, 1, 1},
                        {0, 0, 0}
                    };
                default:
                    throw new IllegalArgumentException("Type de pièce inconnu");
            }
        }
    
        public void rotate() {
            int size = shape.length;
            int[][] rotated = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotated[j][size - 1 - i] = shape[i][j];
                }
            }
            
            shape = rotated;
        }
    
        public void printShape() {
            for (int[] row : shape) {
                for (int cell : row) {
                    System.out.print(cell == 1 ? "█ " : ". ");
                }
                System.out.println();
            }
        }
    }
}
