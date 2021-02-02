package es.duonet.providers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table ( name = "providers")
public class Provider {

    @Id
    @Column ( name = "id")
    private Integer id;

    @Column ( name = "name")
    private String name;

    @Column ( name = "inserted")
    private LocalDateTime inserted;

    @Column ( name = "id_client")
    private int idClient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getInserted() {
        return inserted;
    }

    public void setInserted(LocalDateTime inserted) {
        this.inserted = inserted;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id:").append(id).append(" || ");
        stringBuilder.append("name:").append(name).append(" || ");
        stringBuilder.append("inserted:").append(inserted).append(" || ");
        stringBuilder.append("idClient:").append(idClient);
        return stringBuilder.toString();
    }
}
