package gameEntitiesAttributes;

public class MonsterAttributes extends HostileEntityAttributes {

    public MonsterAttributes(){
        super();
    }

    public MonsterAttributes clone(){
        MonsterAttributes monsterAttributes = new MonsterAttributes();
        cloneTo(monsterAttributes);
        return monsterAttributes;
    }
}