package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int flightTime;

    public Ticket(int id, int price, String from, String to, int flightTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket t) {
        return this.price - t.price;
    }
}
