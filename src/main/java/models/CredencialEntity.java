package models;

import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "credencial", schema = "registro", catalog = "")
@CascadeOnDelete
public class CredencialEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcredencial")
    private int idcredencial;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "activo")
    private Boolean activo;
    @Basic
    @Column(name = "idestudiante")
    private Integer idestudiante;



    public CredencialEntity(String username, String password, Boolean activo, Integer idestudiante) {
        this.username = username;
        this.password = password;
        this.activo = activo;
        this.idestudiante = idestudiante;
    }

    public CredencialEntity() {

    }

    public int getIdcredencial() {
        return idcredencial;
    }

    public void setIdcredencial(int idcredencial) {
        this.idcredencial = idcredencial;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredencialEntity that = (CredencialEntity) o;
        return idcredencial == that.idcredencial && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(activo, that.activo) && Objects.equals(idestudiante, that.idestudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcredencial, username, password, activo, idestudiante);
    }
}
