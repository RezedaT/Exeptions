package ru.netoloqy;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Не найден товар id = " + id );
    }
}
