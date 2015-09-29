/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author moreira-j
 */
@Entity
@Table(name = "cliente")
/*@NamedQueries({
 @NamedQuery(name = "cliente.findAll", query = "SELECT c FROM cliente c")})
 */
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient", unique = true, nullable = false)
    private Integer id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cliente")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private Set<BankAccount> bankAccountList = new HashSet<BankAccount>(0);

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<BankAccount> getBankAccountList() {
        return bankAccountList;
    }

    public void setBankAccountList(Set<BankAccount> bankAccountList) {
        this.bankAccountList = bankAccountList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Client[IdClient=" + id + "]";
    }

}
