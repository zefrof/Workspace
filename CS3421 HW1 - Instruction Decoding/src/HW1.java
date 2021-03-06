/***
 * @author Darren Wiltse
 * dkwiltse@mtu.edu
 * 
 * CS3421
 * Homework Assignment 1: Instruction Decoding
 *  
 */
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class HW1 {
	
	static String[] registers = {"$zero", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3",
			"$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1",
			"$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1",
			"$gp", "$sp", "$fp", "$ra"};

	public static void main(String[] args) throws IOException {
		//read in the hex code, convert it to binary, then seperate the opcode from the rest
		Scanner sc = new Scanner(System.in);
		String input = sc.next().toString();
		sc.close();
		String bin = hexToBin(input);
		String opCode = bin.substring(0, 6);
		String info = bin.substring(6, bin.length());
		
		//Send the register, immediate, ect information to the correct function
		if(opCode.equals("000000")){
			rFormat(info);
		} else if (opCode.equals("100011")){
			loadWord(info);
		} else if (opCode.equals("101011")){
			storeWord(info);
		} else if (opCode.equals("000100")){
			branchOnEqual(info);
		} else if(opCode.equals("000010")){
			jump(info);
		}
		
		//System.out.println(bin);
		//System.out.println(opCode);
		//System.out.println(info);
	}
	
	//Converts a string from binary to hex
	static String hexToBin(String s) {
		String temp = new BigInteger(s, 16).toString(2);
		return String.format("%32s", temp).replace(" ", "0");
	}
	
	//Seperated the function code from the back of r format instructions
	//then passes the register information to the related funtion
	static void rFormat(String con) {
		String reg = con.substring(0, 20);
		String funct = con.substring(20, con.length());
		
		if(funct.equals("100000")){
			add(reg);
		} else if(funct.equals("100010")){
			sub(reg);
		} else if(funct.equals("100100")){
			and(reg);
		} else if(funct.equals("100101")){
			or(reg);
		} else if(funct.equals("101010")){
			slt(reg);
		}
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the add instruction.
	static void add(String reg){
		String rsS = reg.substring(0, 5);
		String rtS = reg.substring(5, 10);
		String rdS = reg.substring(10, 15);
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int rd = Integer.parseInt(rdS, 2);
		
		System.out.println("add " + registers[rd] + "," 
				+ registers[rs] + "," + registers[rt]);
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the sub instruction.
	static void sub(String reg){
		String rsS = reg.substring(0, 5);
		String rtS = reg.substring(5, 10);
		String rdS = reg.substring(10, 15);
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int rd = Integer.parseInt(rdS, 2);
		
		System.out.println("sub " + registers[rd] + "," 
				+ registers[rs] + "," + registers[rt]);
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the and instruction.
	static void and(String reg){
		String rsS = reg.substring(0, 5);
		String rtS = reg.substring(5, 10);
		String rdS = reg.substring(10, 15);
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int rd = Integer.parseInt(rdS, 2);
		
		System.out.println("and " + registers[rd] + "," 
				+ registers[rs] + "," + registers[rt]);
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the or instruction.
	static void or(String reg){
		String rsS = reg.substring(0, 5);
		String rtS = reg.substring(5, 10);
		String rdS = reg.substring(10, 15);
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int rd = Integer.parseInt(rdS, 2);
		
		System.out.println("or " + registers[rd] + "," 
				+ registers[rs] + "," + registers[rt]);
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the slt instruction.
	static void slt(String reg){
		String rsS = reg.substring(0, 5);
		String rtS = reg.substring(5, 10);
		String rdS = reg.substring(10, 15);
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int rd = Integer.parseInt(rdS, 2);
		
		System.out.println("slt " + registers[rd] + "," 
				+ registers[rs] + "," + registers[rt]);
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the lw instruction.
	static void loadWord(String con) {
		String rsS = con.substring(0, 5);
		String rtS = con.substring(5, 10);
		String valS = con.substring(10, con.length());
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int val = Integer.parseInt(valS, 2);
		
		System.out.println("lw " + registers[rt] + "," 
				+ val + "(" + registers[rs] + ")");
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the sw instruction.
	static void storeWord(String con) {
		String rsS = con.substring(0, 5);
		String rtS = con.substring(5, 10);
		String valS = con.substring(10, con.length());
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int val = Integer.parseInt(valS, 2);
		
		System.out.println("sw" + " " + registers[rt] + " " 
				+ val + "(" + registers[rs] + ")");
	}
	
	//Takes a string for an input, then sperated the information contained into
	//the correct registers. The strings are then converted to integers.
	//After that it outputs the beq instruction.
	static void branchOnEqual(String con) {
		String rsS = con.substring(0, 5);
		String rtS = con.substring(5, 10);
		String valS = con.substring(10, con.length());
		
		int rs = Integer.parseInt(rsS, 2);
		int rt = Integer.parseInt(rtS, 2);
		int val = Integer.parseInt(valS, 2);
		
		System.out.println("beq " + registers[rt] + "," 
				+ registers[rs] + "," + (val * 4 + 4));
	}
	
	//Takes a string for an input, then converts the string into a base ten integer.
	//It then outputs the jump instruction.
	static void jump(String con) {
		int wordAdd = Integer.parseInt(con, 2);
		
		System.out.println("j " + (wordAdd * 4));
	}
}
