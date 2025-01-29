package fr.eseo.tetris;

public class Main {
    public static void main(String[] args) {
        Piece piece = new Piece(Tetromino.T);
        piece.printShape();
        System.out.println("\nRotation:");
        piece.rotate();
        piece.printShape();
    }
    
}
