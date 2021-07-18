package it.farmabyte.app.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class RicercaFarmaciDTO
{
    private Date inizio;
    private Date fine;
}