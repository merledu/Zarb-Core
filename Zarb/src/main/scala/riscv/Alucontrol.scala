package riscv
import chisel3._
import chisel3.util.Cat
class Alucontrol extends Module{
	val io=IO(new Bundle{
		val aluop=Input(UInt(3.W))
		val funct3=Input(UInt(3.W))
		val funct7=Input(UInt(1.W))
		val alucontoutput=Output(UInt(5.W))
})
		//R Type
		when(io.aluop==="b000".U){
			io.alucontoutput:= Cat(0.U,io.funct7,io.funct3)	
		//SB Type
		} .elsewhen(io.aluop==="b010".U){
			io.alucontoutput:= Cat("b10".U,io.funct3)	
		//jal jalr
		} .elsewhen(io.aluop==="b011".U){
			io.alucontoutput:= "b11111".U	
		//I Type
		} .elsewhen(io.aluop==="b001".U){
			io.alucontoutput:= Cat("b0".U,io.funct7,io.funct3)
		//Load 
		} .elsewhen(io.aluop==="b100".U){
			io.alucontoutput:= "b00000".U	
		//S Type Store
		} .elsewhen(io.aluop==="b101".U){
			//Sw instruction
			io.alucontoutput:= "b00000".U	
		//U Type lui
		} .elsewhen(io.aluop==="b110".U){
			//Sw instruction
			io.alucontoutput:= "b00000".U					
		}.otherwise{
			io.alucontoutput:=DontCare		
		}					
}
