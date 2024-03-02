package com.waly.azShipMongo.domain;

import java.util.List;

public class CustomPage<T> {

    private List<T> content;
    private boolean isLast;
    private boolean isEmpty;
    private int totalPages;
    private int totalElements;
    private int number;
    private int numberOfElements;
    private int size;
    private boolean isFirst;

    public CustomPage() {
    }

    public CustomPage(List<T> content, boolean isLast, boolean isEmpty, int totalPages, int totalElements, int number, int numberOfElements, int size, boolean isFirst, boolean hasNext, boolean hasPrevious) {
        this.content = content;
        this.isLast = isLast;
        this.isEmpty = isEmpty;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.number = number;
        this.numberOfElements = numberOfElements;
        this.size = size;
        this.isFirst = isFirst;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }
}
