interface Status {
    String getStatusName();
    void applyStatus(Character target);
    void removeStatus(Character target);
}