package ru.netoloqy;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id) {
        super("Существует товар с id = " + id);
    }
}
