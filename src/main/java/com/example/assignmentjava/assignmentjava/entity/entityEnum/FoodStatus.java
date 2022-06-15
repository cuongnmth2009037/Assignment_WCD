package com.example.assignmentjava.assignmentjava.entity.entityEnum;

public enum FoodStatus {
    đangbán(1),
    dừngbán(0),
    đãxóa(-1),
    khác(-2);
    private int value;

    FoodStatus(int value) {this.value = value;}

    public int getValue(){
        return value;
    }

    public static FoodStatus of(int value){
        for (FoodStatus foodStatus : FoodStatus.values()){
            if (foodStatus.getValue() == value){
                return foodStatus;
            }
        }
        return FoodStatus.khác;
    }
}
