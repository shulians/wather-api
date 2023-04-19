package com.example.proxy.feign.rest.locations;

import lombok.Data;

@Data
public class Locations {
     Integer Version;
     String Key;
     String Type;
     Integer Rank;
     String LocalizedName;
     String EnglishName;
}
