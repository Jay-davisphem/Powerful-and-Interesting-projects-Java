class Bicycle {
    // Data Member
    private String ownerName;
    private String _tagNo;

    // Constructor: Initialzes the data member
    public Bicycle( ) {
        ownerName = "Unknown";
    }

    // Returns the name of this bicycle's owner
    public String getOwnerName( ) {
        return ownerName;
    }
    // Assigns the name of this bicycle's owner
    public void setOwnerName(String name) {
        ownerName = name;
    }
    // Returns the tag number of the bicycle
    public String getTagNo(){
        return _tagNo;
    }
    // Assigns the tag number of the bicycle
    public void setTagNo(String tagNo){
        _tagNo = tagNo;
    }
}
