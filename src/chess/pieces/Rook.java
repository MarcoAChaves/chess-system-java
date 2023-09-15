package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color, Position position) {
        super(board, color);
    }

    public Rook(Board board, Color white) {
        super(board, white);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //Verificando coluna acima livres para ataque.
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        // Verificando as linhas a esquerda livres para ataque.
        p.setValues(position.getRow(), position.getColumn() -1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }
        // Verificando as linhas a direita livres para ataque.
        p.setValues(position.getRow(), position.getColumn() +1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //Verificando coluna abaixo livres para ataque.
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
