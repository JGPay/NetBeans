package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author moreira-j
 */
@Entity
@Table(name = "creditCard")
/*@NamedQueries({
    @NamedQuery(name = "cartaoDeCredito.findAll", query = "SELECT cc FROM cartaoDeCredito cc")})
*/
public class CreditCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true, nullable = false)
    private Integer id;
    private Integer number;
    private Date expirationDate;
    private String securityNumber;
    private Double limitCard;
    private Double usedValue;
    private String cardIssuer;
    private int isMobileActivated;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBankAccount", nullable = false)
    private BankAccount bankAccount;

	public CreditCard() {
    }

    public CreditCard(Integer id) {
        this.id = id;
    }

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	
        
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditCard)) {
            return false;
        }
        CreditCard other = (CreditCard) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CreditCard[idCreditCard=" + getId() + "]";
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the securityNumber
     */
    public String getSecurityNumber() {
        return securityNumber;
    }

    /**
     * @param securityNumber the securityNumber to set
     */
    public void setSecurityNumber(String securityNumber) {
        this.securityNumber = securityNumber;
    }

    /**
     * @return the limitCard
     */
    public Double getLimitCard() {
        return limitCard;
    }

    /**
     * @param limitCard the limitCard to set
     */
    public void setLimitCard(Double limitCard) {
        this.limitCard = limitCard;
    }

    /**
     * @return the usedValue
     */
    public Double getUsedValue() {
        return usedValue;
    }

    /**
     * @param usedValue the usedValue to set
     */
    public void setUsedValue(Double usedValue) {
        this.usedValue = usedValue;
    }

    /**
     * @return the cardIssuer
     */
    public String getCardIssuer() {
        return cardIssuer;
    }

    /**
     * @param cardIssuer the cardIssuer to set
     */
    public void setCardIssuer(String cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    /**
     * @return the isMobileActivated
     */
    public int getIsMobileActivated() {
        return isMobileActivated;
    }

    /**
     * @param isMobileActivated the isMobileActivated to set
     */
    public void setIsMobileActivated(int isMobileActivated) {
        this.isMobileActivated = isMobileActivated;
    }

    /**
     * @param bankAccount the bankAccount to set
     */
    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

}