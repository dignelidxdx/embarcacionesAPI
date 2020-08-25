package ar.com.noaa.api.embarcaciones.entities;

public class Faro {
    
    public enum FaroEnum {
        ROJO(1), AMARILLO(2), VERDE(3), AZUL(4);

        private final Integer value;

        private FaroEnum(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public static FaroEnum parse(Integer id) {
            FaroEnum status = null; 
            for (FaroEnum item : FaroEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}