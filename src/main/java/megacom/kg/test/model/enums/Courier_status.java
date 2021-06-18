package megacom.kg.test.model.enums;


public enum Courier_status {
УВОЛЕН ("УВОЛЕН"), НА_СМЕНЕ("НА_СМЕНЕ"), ОТПУСК("ОТПУСК"), ВЫХОДНОЙ("ВЫХОДНОЙ"), ВНЕ_СМЕНЫ("ВНЕ_СМЕНЫ");
//    УВОЛЕН , НА_СМЕНЕ, ОТПУСК, ВЫХОДНОЙ, ВНЕ_СМЕНЫ;

private final String status;

    Courier_status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
