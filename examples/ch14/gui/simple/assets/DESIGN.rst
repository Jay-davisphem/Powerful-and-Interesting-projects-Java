      +----------------------+
      |        Asset         |
      +----------------------+
      | -assetID: String      |
      | -manufacturer: String|
      | -model: String        |
      | -purchaseDate: Date   |
      | -purchasePrice: float |
      | -currentLocation: String |
      | -owner: String        |
      +----------------------+
      | +track(): String      |
      | +depreciate(): float  |
      +----------------------+
                  ^
                  |
                  |
      +----------------------+   +-----------------------+
      |   ElectronicAppliance |   |       Automobile      |
      +----------------------+   +-----------------------+
      | -powerUsage: float    |   | -make: String          |
      | -voltage: int         |   | -model: String         |
      | -wattage: int         |   | -year: int             |
      +----------------------+   | -mileage: float        |
      | +turnOn(): void       |   | -vin: String           |
      | +turnOff(): void      |   | -fuelType: String      |
      | +setTemperature(): void|   | -engineSize: float     |
      | +getTemperature(): int|   +-----------------------+
      | +setPowerLevel(): void|   | +startEngine(): void   |
      | +getPowerLevel(): int |   | +stopEngine(): void    |
      +----------------------+   | +accelerate(): void    |
                                  | +brake(): void         |
                                  | +fillFuel(): void      |
                                  +-----------------------+
                                              ^
                                              |
                                              |
                                +------------------------+
                                |       Furniture        |
                                +------------------------+
                                | -material: String      |
                                | -dimensions: Dimension |
                                | -color: String         |
                                | -isAssembled: boolean   |
                                +------------------------+
                                | +assemble(): void      |
                                | +disassemble(): void   |
                                | +paint(): void         |
                                +------------------------+
                                              ^
                                              |
                                              |
                                  +----------------------+
                                  |      CompactDisk     |
                                  +----------------------+
                                  | -artist: String      |
                                  | -title: String       |
                                  | -genre: String       |
                                  | -duration: int       |
                                  +----------------------+
                                  | +play(): void        |
                                  | +stop(): void        |
                                  | +skipForward(): void |
                                  | +skipBackward(): void|
                                  +----------------------+


Class Descriptions
Asset

    Description: The superclass for all assets. Contains common attributes and methods shared by all asset types.
    Attributes:
        assetID (private String): Unique identifier for each asset.
        manufacturer (private String): Manufacturer of the asset.
        model (private String): Model of the asset.
        purchaseDate (private Date): Date the asset was purchased.
        purchasePrice (private float): Price at which the asset was purchased.
        currentLocation (private String): Current location of the asset.
        owner (private String): Owner of the asset.
    Methods:
        track(): String: Returns the current location of the asset.
        depreciate(): float: Calculates the depreciation of the asset.

ElectronicAppliance

    Description: A subclass of Asset that represents electronic appliances.
    Attributes:
        `powerUsage` (private `float`): The power usage of the electronic appliance.

    voltage (private int): The voltage of the electronic appliance.
    wattage (private int): The wattage of the electronic appliance.
    Methods:
        turnOn(): void: Turns on the electronic appliance.
        turnOff(): void: Turns off the electronic appliance.
        setTemperature(): void: Sets the temperature of the electronic appliance (for appliances like air conditioners or refrigerators).
        getTemperature(): int: Gets the current temperature of the electronic appliance.
        setPowerLevel(): void: Sets the power level of the electronic appliance (for appliances like blenders or mixers).
        getPowerLevel(): int: Gets the current power level of the electronic appliance.

Automobile

    Description: A subclass of Asset that represents automobiles.
    Attributes:
        make (private String): The make of the automobile.
        model (private String): The model of the automobile.
        year (private int): The year of the automobile.
        mileage (private float): The mileage of the automobile.
        vin (private String): The Vehicle Identification Number (VIN) of the automobile.
        fuelType (private String): The type of fuel used by the automobile.
        engineSize (private float): The size of the engine in the automobile.
    Methods:
        startEngine(): void: Starts the automobile's engine.
        stopEngine(): void: Stops the automobile's engine.
        accelerate(): void: Accelerates the automobile.
        brake(): void: Applies the brakes in the automobile.
        fillFuel(): void: Fills up the fuel in the automobile.

Furniture

    Description: A subclass of Asset that represents furniture.
    Attributes:
        material (private String): The material of the furniture.
        dimensions (private Dimension): The dimensions of the furniture.
        color (private String): The color of the furniture.
        isAssembled (private boolean): Indicates whether the furniture is assembled or not.
    Methods:
        assemble(): void: Assembles the furniture.
        disassemble(): void: Disassembles the furniture.
        paint(): void: Paints the furniture.

CompactDisk

    Description: A subclass of Asset that represents compact disks.
    Attributes:
        artist (private String): The artist of the compact disk.
        title (private String): The title of the compact disk.
        genre (private String): The genre of the compact disk.
        duration (private int): The duration of the compact disk in minutes.
    Methods:
        play(): void: Plays the compact disk.
        stop(): void: Stops playing the compact disk.
        skipForward(): void: Skips forward to the next track on the compact disk.
        skipBackward(): void: Skips backward to the previous track on the compact disk.

Dimension

    Description: A helper class that represents the dimensions of furniture.
    Attributes:
        length (private float): The length of the furniture.
        width (private float): The width of the furniture.
        height (private float): The height of the furniture.

    Methods:
        getLength(): float: Gets the length of the furniture.
        getWidth(): float: Gets the width of the furniture.
        getHeight(): float: Gets the height of the furniture.

Conclusion

In this design, we have used a superclass Asset and four subclasses ElectronicAppliance, Automobile, Furniture, and CompactDisk. The Asset class defines the basic attributes and methods that all assets share. The subclasses inherit from the Asset class and define additional attributes and methods specific to their type of asset.

We have also included a helper class Dimension to represent the dimensions of furniture. This class is used as an attribute of the Furniture class.

Each subclass has a unique set of attributes and methods that define the behavior of the asset. For example, the ElectronicAppliance class has attributes for power usage, voltage, and wattage, and methods for turning the appliance on and off, setting the temperature or power level, and getting the current temperature or power level. Similarly, the Automobile class has attributes for make, model, year, mileage, VIN, fuel type, and engine size, and methods for starting and stopping the engine, accelerating and braking, and filling fuel.

This design allows for easy and organized tracking of different types of assets, and can be expanded upon to include more attributes and methods as needed
