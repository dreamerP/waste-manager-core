package com.example.wastemanagercore.response;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerAddressResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Getter @Setter private String direccion;
    @Getter @Setter private Boolean isEnabled;
}
