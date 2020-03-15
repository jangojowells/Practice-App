package com.looom.loomservice.Model.Instrument;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InstrumentPrimaryKey implements Serializable {

    private Long user;
    private String instrument;

    public InstrumentPrimaryKey() {
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentPrimaryKey that = (InstrumentPrimaryKey) o;
        return user.equals(that.user) &&
                instrument.equals(that.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, instrument);
    }

    @Override
    public String toString() {
        return "InstrumentPrimaryKey{" +
                "user=" + user +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
