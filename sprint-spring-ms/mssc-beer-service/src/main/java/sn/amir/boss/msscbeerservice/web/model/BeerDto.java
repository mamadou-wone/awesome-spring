package sn.amir.boss.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
public class BeerDto {
    private UUID id;
    private Integer version;

    private OffsetDateTime createDte;
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private Long upc;

    private BigDecimal price;

    private  Integer quantityOnHand;

    public BeerDto() {
    }

    public BeerDto(UUID id, Integer version, OffsetDateTime createDte, OffsetDateTime lastModifiedDate, String beerName, BeerStyleEnum beerStyle, Long upc, BigDecimal price, Integer quantityOnHand) {
        this.id = id;
        this.version = version;
        this.createDte = createDte;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.quantityOnHand = quantityOnHand;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OffsetDateTime getCreateDte() {
        return createDte;
    }

    public void setCreateDte(OffsetDateTime createDte) {
        this.createDte = createDte;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public BeerStyleEnum getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(BeerStyleEnum beerStyle) {
        this.beerStyle = beerStyle;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerDto beerDto = (BeerDto) o;
        return Objects.equals(id, beerDto.id) && Objects.equals(version, beerDto.version) && Objects.equals(createDte, beerDto.createDte) && Objects.equals(lastModifiedDate, beerDto.lastModifiedDate) && Objects.equals(beerName, beerDto.beerName) && beerStyle == beerDto.beerStyle && Objects.equals(upc, beerDto.upc) && Objects.equals(price, beerDto.price) && Objects.equals(quantityOnHand, beerDto.quantityOnHand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createDte, lastModifiedDate, beerName, beerStyle, upc, price, quantityOnHand);
    }

    @Override
    public String toString() {
        return "BeerDto{" +
                "id=" + id +
                ", version=" + version +
                ", createDte=" + createDte +
                ", lastModifiedDate=" + lastModifiedDate +
                ", beerName='" + beerName + '\'' +
                ", beerStyle=" + beerStyle +
                ", upc=" + upc +
                ", price=" + price +
                ", quantityOnHand=" + quantityOnHand +
                '}';
    }
}
