package com.ojcarlos.simplecrud.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Question3 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)

    private String ask;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)

    private String alternativeA;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)

    private String alternativeB;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)

    private String alternativeC;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)
    private String alternativeD;
    @Column(nullable = true, columnDefinition = "TEXT", length = 10000)

    private String answer;
    public Question3() {
    }

    public Question3(Long id, String ask, String alternativeA, String alternativeB, String alternativeC, String alternativeD, String answer) {
        this.id = id;
        this.ask = ask;
        this.alternativeA = alternativeA;
        this.alternativeB = alternativeB;
        this.alternativeC = alternativeC;
        this.alternativeD = alternativeD;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAlternativeA() {
        return alternativeA;
    }

    public void setAlternativeA(String alternativeA) {
        this.alternativeA = alternativeA;
    }

    public String getAlternativeB() {
        return alternativeB;
    }

    public void setAlternativeB(String alternativeB) {
        this.alternativeB = alternativeB;
    }

    public String getAlternativeC() {
        return alternativeC;
    }

    public void setAlternativeC(String alternativeC) {
        this.alternativeC = alternativeC;
    }

    public String getAlternativeD() {
        return alternativeD;
    }

    public void setAlternativeD(String alternativeD) {
        this.alternativeD = alternativeD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question3 question3)) return false;
        return id.equals(question3.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
