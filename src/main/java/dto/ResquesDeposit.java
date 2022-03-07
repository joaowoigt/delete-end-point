package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ResquesDeposit {
    private Double deposit;
    private UUID account;
}
