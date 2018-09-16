package musipo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractTimestampEntity {

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date",insertable=true)
    private Date created;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date",insertable=true)
    private Date updated;

    @Column(name = "deleted_flag",insertable=true)
    private int deletedFlag ;

    @Column(name = "associated_user_id")
    private String associatedUserId;

    public int getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(int deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public String getAssociatedUserId() {
        return associatedUserId;
    }

    public void setAssociatedUserId(String associatedUserId) {
        this.associatedUserId = associatedUserId;
    }
}