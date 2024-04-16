package com.example.wastemanagercore.response;

import java.io.Serializable;
import java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Getter @Setter private Long id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String nif;
    @Getter @Setter private WasteManagerAddressResponse wasteManagerAddressResponse;
    @Getter
    @Setter
    private List<WasteCenterAuthorizationResponse> listOfWasteCenterAuthorization;
    @Getter @Setter private Boolean isEnabled;
}
