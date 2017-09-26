/*
** A simulation of a person who needs to get dressed
** Author: David Johnson
** Date: September 25, 2017
*/
package getDressedPackage;

public class Person {
    // Instance Variables
    private boolean pajamasOn;  // Are pajamas on?
    private boolean footwearOn; // Is footwear on?
    private boolean headwearOn; // Is headwear on?
    private boolean socksOn;    // Are socks on?
    private boolean shirtOn;    // Is shirt on?
    private boolean jacketOn;   // Is jacket on?
    private boolean pantsOn;    // Are pants on?
    private boolean inHouse;    // Is person inside house?
    private boolean hotOutside; // Is it hot outside?
    private boolean coldOutside;// Is it cold outside?
    
    // Constructor
    public Person() {
        // We start off wearing pajamas and in the house
        this.pajamasOn = true;
        this.footwearOn = false;
        this.headwearOn = false;
        this.socksOn = false;
        this.shirtOn = false;
        this.jacketOn = false;
        this.pantsOn = false;
        this.inHouse = true;
        this.hotOutside = false;
        this.coldOutside = false;
    }
    
    // Business Rules
    public String input(String hotOrCold, int[] commands) {
        String output = "";
        // Setting outside temperature
        if(hotOrCold.equalsIgnoreCase("hot")) {
            this.setHotOutside(true);
        }
        else if(hotOrCold.equalsIgnoreCase("cold")) {
            this.setColdOutside(true);
        }
        else {
            return "fail";
        }
        
        // Now we'll process the commands
        if(commands[0] != 8) {  // If the first command isn't taking off the PJ's we just fail
            return "fail";
        }
        for(int command: commands) {
            switch(command) {
                // Put on footwear
                case 1: if(!this.getFootwearOn()) { // Make sure we haven't already done this step
                            if(this.getHotOutside()) {
                                output += "sandals, ";
                                this.setFootwearOn(true);
                            } else {
                                if(this.getSocksOn() && this.getPantsOn()) { // Socks and pants MUST be on before shoes
                                    output += "boots, ";
                                    this.setFootwearOn(true);
                                } else {
                                    output += "fail";
                                    return output;
                                }
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Put on headwear
                case 2: if(!this.getHeadwearOn()) {     // Make sure we haven't already done this step
                            if(this.getShirtOn()) {     // Shirt MUST be on before headwear
                                if(this.getHotOutside()) {
                                    output += "sun visor, ";
                                        this.setHeadwearOn(true);
                                } else {
                                    output += "hat, ";
                                    this.setHeadwearOn(true);
                                }
                            } else {
                                output += "fail";
                                return output;
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Put on socks
                case 3: if(!this.getSocksOn()) {    // Make sure we haven't already done this step
                            if(this.getHotOutside()) {  // Don't wear socks when it's hot!
                                output += "fail";
                                return output;
                            } else {
                                output += "socks, ";
                                this.setSocksOn(true);
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Put on shirt
                case 4: if(!this.getShirtOn()) {    // Make sure we haven't already done this step
                            if(this.getHotOutside()) {
                                output += "t-shirt, ";
                                this.setShirtOn(true);
                            } else {
                                output += "shirt, ";
                                this.setShirtOn(true);
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Put on jacket
                case 5: if(!this.getJacketOn()) {   // Make sure we haven't already done this step
                            if(this.getShirtOn()) {     // Shirt MUST be on before jacket
                                if(this.getHotOutside()) {
                                    output += "fail";
                                    return output;
                                } else {
                                    output += "jacket, ";
                                    this.setJacketOn(true);
                                }
                            } else {
                                output += "fail";
                                return output;
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Put on pants
                case 6: if(!this.getPantsOn()) {    // Make sure we haven't already done this step
                            if(this.getHotOutside()) {
                                output += "shorts, ";
                                this.setPantsOn(true);
                            } else {
                                output += "pants, ";
                                this.setPantsOn(true);
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Leave House
                // One of each appropriate clothing type MUST be on to leave the house
                case 7: if(this.getInHouse()) {    // Make sure we haven't already done this step
                            if(this.getHotOutside() && this.getFootwearOn() && this.getHeadwearOn() &&
                                this.getShirtOn() && this.getPantsOn()) {
                                    output += "leaving house";
                                    this.setInHouse(false);
                            } else if(this.getColdOutside() && this.getFootwearOn() && this.getHeadwearOn() &&
                                this.getSocksOn() && this.getShirtOn() && this.getJacketOn() && this.getPantsOn()) {
                                    output += "leaving house";
                                    this.setInHouse(false);
                            } else {
                                output += "fail";
                                return output;
                            }
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Take off pajamas
                case 8: if(this.getPajamasOn()) {  // Make sure we haven't already done this step
                            output += "Removing PJs, ";
                            this.setPajamasOn(false);
                        } else {
                            output += "fail";
                            return output;
                        }
                        break;
                // Anything else is an error
                default:    output += "fail";
                            return output;
            }
        }
        
        return output;
    }
    
    // Here come the accessors
    public void setPajamasOn(boolean value) {
        this.pajamasOn = value;
    }
    
    public boolean getPajamasOn() {
        return this.pajamasOn;
    }
    
    public void setFootwearOn(boolean value) {
        this.footwearOn = value;
    }
    
    public boolean getFootwearOn() {
        return this.footwearOn;
    }
    
    public void setHeadwearOn(boolean value) {
        this.headwearOn = value;
    }
    
    public boolean getHeadwearOn() {
        return this.headwearOn;
    }
    
    public void setSocksOn(boolean value) {
        this.socksOn = value;
    }
    
    public boolean getSocksOn() {
        return this.socksOn;
    }
    
    public void setShirtOn(boolean value) {
        this.shirtOn = value;
    }
    
    public boolean getShirtOn() {
        return this.shirtOn;
    }
    
    public void setJacketOn(boolean value) {
        this.jacketOn = value;
    }
    
    public boolean getJacketOn() {
        return this.jacketOn;
    }
    
    public void setPantsOn(boolean value) {
        this.pantsOn = value;
    }
    
    public boolean getPantsOn() {
        return this.pantsOn;
    }
    
    public void setInHouse(boolean value) {
        this.inHouse = value;
    }
    
    public boolean getInHouse() {
        return this.inHouse;
    }
    
    public void setHotOutside(boolean value) {
        this.hotOutside = value;    // These two can not be the same
        this.coldOutside = !value;
    }
    
    public boolean getHotOutside() {
        return this.hotOutside;
    }
    
    public void setColdOutside(boolean value) {
        this.coldOutside = value;   // These two can not be the same
        this.hotOutside = !value;
    }
    
    public boolean getColdOutside() {
        return this.coldOutside;
    }
}