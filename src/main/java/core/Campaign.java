package core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import utils.DateDeserializer;
import utils.DateSerializer;

import java.util.Date;
import java.util.UUID;

/**
 * Campaing class representation.
 */
public class Campaign {
    private String name;
    private UUID id;
    private long teamId;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private final Date dateCreated;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dateStart;

    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dateEnd;

    public Campaign() {
        // empty constructor
        this.dateCreated = new Date();
    }

    public Campaign(String name, long teamId, Date dateStart, Date dateEnd) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.teamId = teamId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dateCreated = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return String.format("%s (%s - %s)", name, dateStart, dateEnd);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Campaign)) {
            return false;
        }

        Campaign c = (Campaign) o;

        return this.name.equals(c.getName());
    }
}
