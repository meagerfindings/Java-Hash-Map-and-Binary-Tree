package com.company;

public class Main {

    public static void main(String[] args) {

//MJG: initialization of the "hashTable" array
    HashMaker hashTable = new HashMaker();
    hashTable.createSimpleHash();

//MJG: Code to print out a line and header.
    for (int i = 0; i < 20; i++) {
        System.out.print("------");
    }
    System.out.println("\nTesting Hash Table Data Structure:\n");

//MJG: Test Cases for hash table data structure:
    //Test Case1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com
    hashTable.addHashElement("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");

    //Test Case2: Insert Jane Williams 555-235-1112 jw@something.com
    hashTable.addHashElement("Jane", "Williams", "555-235-112", "jw@something.com");

    //Test Case3: Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
    hashTable.addHashElement("Mohammed", "al-Salaam", "555-235-1113", "mas@sompelace.com");

    //Test Case4: Insert Pat Jones 555-235-1114 pjones@homesweethome.com
    hashTable.addHashElement("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");

    //Test Case5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
    hashTable.addHashElement("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");

    //Test Case6: Insert H. Houdini 555-235-1116 houdini@noplace.com
    hashTable.addHashElement("H.", "Houdini", "555-235-1116", "houdin@noplace.com");

    //Test Case7: Insert Jack Jones 555-235-1117 jjones@hill.com
    hashTable.addHashElement("Jack", "Jones", "555-235-1117", "jjones@hill.com");

    //Test Case8: Insert Jill Jones 555-235-1118 jillj@hill.com
    hashTable.addHashElement("Jill", "Jones", "555-235-1118", "jillj@hill.com");

    //Test Case9: Insert John Doe 555-235-1119 jdoe@somedomain.com
    hashTable.addHashElement("John", "Doe", "555-235-1119", "jdoe@somedomain.com");

    //Test Case10: Insert Jane Doe 555-235-1120 jdoe@somedomain.com
    hashTable.addHashElement("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

    //Test Case11: Lookup Pat Jones
    hashTable.lookUpValue("Pat", "Jones");

    //Test Case12: Lookup Billy Kidd
    hashTable.lookUpValue("Billy", "Kidd");

    //Test Case13: Delete John Doe
    hashTable.deleteEntry("John", "Doe");

    //Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com
    hashTable.addHashElement("Test", "Case", "555-235-1121", "Test_Case@testcase.com");

    //Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
    hashTable.addHashElement("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");

    //Test Case16: Insert Jo Wu 555-235-1123 wu@h.com
    hashTable.addHashElement("Jo", "Wu", "555-235-1123", "wu@h.com");

    //Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
    hashTable.addHashElement("Millard", "Fillmore", "555-235-1124", "millared@thewactualwhitehouse.us");

    //Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
    hashTable.addHashElement("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");

    //Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
    hashTable.addHashElement("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");

    //Test Case20: Lookup Jack Jones
    hashTable.lookUpValue("Jack", "Jones");

    //Test Case21: Lookup Nadezhda Kanachekhovskaya
    hashTable.lookUpValue("Nadezhda", "Kanachekhovskaya");

    //Test Case22: Delete Jill Jones
    hashTable.deleteEntry("Jill", "Jones");

    //Test Case23: Delete John Doe
    hashTable.deleteEntry("John", "Doe");

    //Test Case24: Lookup Jill Jones (What should happen if the “lookup” message doesn’t find the entry?)
    hashTable.lookUpValue("Jill", "Jones");

    //Test Case25: Lookup John Doe
    hashTable.lookUpValue("John", "Doe");

    //hashTable.printHash();

//MJG: Code to print out a line and header
     System.out.print("\n");
     for (int i = 0; i < 20; i++) {
            System.out.print("------");
     }
     System.out.println("\nTesting Tree Data Structure:\n");


//MJG: initialization of the binary tree data structure
    BinaryTree newTree = new BinaryTree();
    newTree.Binarytree();

//MJG: Test Cases for tree data structure:
    //Test Case1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com
    newTree.addTreeEntry("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");

    //Test Case2: Insert Jane Williams 555-235-1112 jw@something.com
    newTree.addTreeEntry("Jane", "Williams", "555-235-112", "jw@something.com");

    //MJG: Additional test cases used to add rootnode, another entry, remove root node, and then test if we deleted the entire tree in deleting the rootnode.
    //newTree.removeTreeNode("Bob", "Smith");
    //newTree.searchTreeNode("Jane", "Williams");

    //Test Case3: Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
    newTree.addTreeEntry("Mohammed", "al-Salaam", "555-235-1113", "mas@sompelace.com");

    //Test Case4: Insert Pat Jones 555-235-1114 pjones@homesweethome.com
    newTree.addTreeEntry("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");

    //Test Case5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
    newTree.addTreeEntry("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");

    //Test Case6: Insert H. Houdini 555-235-1116 houdini@noplace.com
    newTree.addTreeEntry("H.", "Houdini", "555-235-1116", "houdin@noplace.com");

    //Test Case7: Insert Jack Jones 555-235-1117 jjones@hill.com
    newTree.addTreeEntry("Jack", "Jones", "555-235-1117", "jjones@hill.com");

    //Test Case8: Insert Jill Jones 555-235-1118 jillj@hill.com
    newTree.addTreeEntry("Jill", "Jones", "555-235-1118", "jillj@hill.com");

    //Test Case9: Insert John Doe 555-235-1119 jdoe@somedomain.com
    newTree.addTreeEntry("John", "Doe", "555-235-1119", "jdoe@somedomain.com");

    //Test Case10: Insert Jane Doe 555-235-1120 jdoe@somedomain.com
    newTree.addTreeEntry("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

    //Test Case11: Lookup Pat Jones
    newTree.searchTreeNode("Pat", "Jones");

    //Test Case12: Lookup Billy Kidd
    newTree.searchTreeNode("Billy", "Kidd");

    //Test Case13: Delete John Doe
    newTree.removeTreeNode("John", "Doe");

    //Test Case14: Insert Test Case 555-235-1121 Test_Case@testcase.com
    newTree.addTreeEntry("Test", "Case", "555-235-1121", "Test_Case@testcase.com");

    //Test Case15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
    newTree.addTreeEntry("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");

    //Test Case16: Insert Jo Wu 555-235-1123 wu@h.com
    newTree.addTreeEntry("Jo", "Wu", "555-235-1123", "wu@h.com");

    //Test Case17: Insert Millard Fillmore 555-235-1124 millard@theactualwhitehouse.us
    newTree.addTreeEntry("Millard", "Fillmore", "555-235-1124", "millared@thewactualwhitehouse.us");

    //Test Case18: Insert Bob vanDyke 555-235-1125 vandyke@nodomain.com
    newTree.addTreeEntry("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");

    //Test Case19: Insert Upside Down 555-235-1126 upsidedown@rightsideup.com
    newTree.addTreeEntry("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");

    //Test Case20: Lookup Jack Jones
    newTree.searchTreeNode("Jack", "Jones");

    //Test Case21: Lookup Nadezhda Kanachekhovskaya
    newTree.searchTreeNode("Nadezhda", "Kanachekhovskaya");

    //Test Case22: Delete Jill Jones
    newTree.removeTreeNode("Jill", "Jones");

    //Test Case23: Delete John Doe
    newTree.removeTreeNode("John", "Doe");

    //Test Case24: Lookup Jill Jones (What should happen if the “lookup” message doesn’t find the entry?)
    newTree.searchTreeNode("Jill", "Jones");

    //Test Case25: Lookup John Doe
    newTree.searchTreeNode("John", "Doe");



    //newTree.getTreeSize(); //MJG: used to check amount of nodes added and removed during testing.


    }
}
