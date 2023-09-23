//package com.example.deokjideokji.restaurant.domain;
//
//import com.example.deokjideokji.common.domain.BaseEntity;
//import com.example.deokjideokji.restaurant.domain.vo.Type;
//import lombok.AccessLevel;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//public class Restaurant extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    @Enumerated
//    private Type type;
//
//    @Column
//    private Double latitude;
//
//    @Column
//    private Double longitude;
//
//    @Column
//    private String name;
//
//    @Column
//    private String location;
//
//
//    @Builder
//    public Restaurant(Type type, Double latitude, Double longitude,
//                      String name, String location){
//        this.type = type;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.name = name;
//        this.location = location;
//    }
//}
