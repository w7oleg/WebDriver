package hardcore.resources;

public class GooglePageResources {
    private final String choiceNumberOfIntances = "4";
    private final String choiceOperationSystem = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private final String choiceMachineClass = "Regular";
    private final String choiceSeries = "N1";
    private final String choiceMachineType = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private final String choiceNumberGPUs = "1";
    private final String choiceTypeGPU = "NVIDIA Tesla V100";
    private final String choiceLocalSSD = "2x375 GB";
    private final String choiceDatacentrLocacion = "Frankfurt (europe-west3)";
    private final String choiceCmmittedUsage = "1 Year";
    private final String resultManualTest = "1,083.33";
    private final String costStringDescription = "Estimated Monthly Cost";
    private String resultPriceCalculator = "";

    private final String descriptionPriceField = "Estimated Component Cost";
    public static final String vmClassField = "VM class";
    public static final String instanceTypeField = "Instance type";
    public static final String regionField =  "Region";
    public static final String localSSDField =  "local SSD";
    public static final String commitmentTermField =  "Commitment term";

    public String getChoiceNumberOfIntances(){
        return choiceNumberOfIntances;
    }

    public String getChoiceOperationSystem(){
        return choiceOperationSystem;
    }

    public String getChoiceMachineClass(){
        return choiceMachineClass;
    }

    public String getChoiceSeries(){
        return choiceSeries;
    }

    public String getChoiceMachineType(){
        return choiceMachineType;
    }

    public String getChoiceNumberGPUs(){
        return choiceNumberGPUs;
    }

    public String getChoiceTypeGPU(){
        return choiceTypeGPU;
    }

    public String getChoiceLocalSSD(){
        return choiceLocalSSD;
    }

    public String getChoiceDatacentrLocacion(){
        return choiceDatacentrLocacion;
    }

    public String getChoiceCmmittedUsage(){
        return choiceCmmittedUsage;
    }

    public String getResultManualTest(){
        return resultManualTest;
    }

    public String getCostStringDescription(){
        return costStringDescription;
    }

    public String getResultPriceCalculator(){
        return resultPriceCalculator;
    }

    public void setResultPriceCalculator(String resultPriceCalculator){
        this.resultPriceCalculator = resultPriceCalculator;
    }
}
