package edu.integrador2.serviciosgenerales.entity;

public abstract class BaseEntity<E> {

    public abstract void setId(E e);

    public abstract E getId();
}
