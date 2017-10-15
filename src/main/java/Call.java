import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Call {
    @Id
    @GeneratedValue

    @Column
    private Integer id;

    @Column
    private Date callDate;

    @Column
    private BigInteger phoneNumber;

    public Integer getRow_id() {
        return id;
    }

    public void setRow_id(Integer row_id) {
        this.id = row_id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Call getCallPhone() {
        return callPhone;
    }

    public void setCallPhone(Call callPhone) {
        this.callPhone = callPhone;
    }

    @ManyToOne
    @JoinColumn(name = "phonID", foreignKey = @ForeignKey(name = "fk_call_id"))
    private Call callPhone;
}
