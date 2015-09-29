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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author moreira-j
 */
@Entity
@Table(name = "contaBancaria")
/*
 @NamedQueries({
 @NamedQuery(name = "contaBancaria.findAll", query = "SELECT cb FROM contaBancaria cb")})
 */
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String agency;
    private String number;
    private Double balance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Client client;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bankAccount")
    private Set<CreditCard> creditCardList = new HashSet<CreditCard>(0);
    //private ArrayList<BankAccount> listaContaBancaria = new ArrayList<BankAccount>();

    public BankAccount() {
    }

    public BankAccount(Integer idBankAccount) {
        this.id = idBankAccount;
    }

    public Integer getId() {
        return id;
    }

    public Set<CreditCard> getCreditCarkList() {
        return creditCardList;
    }

    public void setCreditCardList(Set<CreditCard> listaCartaoCredito) {
        this.creditCardList = listaCartaoCredito;
    }

    public void setId(Integer idContaBancaria) {
        this.id = idContaBancaria;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agencia) {
        this.agency = agencia;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String numero) {
        this.number = numero;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof BankAccount)) {
            return false;
        }
        BankAccount other = (BankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.BankAccount[bankAccountId=" + id + "]";
    }

}
