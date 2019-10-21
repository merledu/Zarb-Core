package riscv
import chisel3._
import chisel3.core.SInt
import chisel3.util.Fill
class Registerfile extends Module{
val io=IO(new Bundle{
	val in_regwrite=Input(UInt(1.W))
	val in_rs1=Input(UInt(5.W))
	val in_rs2=Input(UInt(5.W))
	val in_rd=Input(UInt(5.W)) 
	val in_writedata=Input(SInt(32.W))
	val out_rs1=Output(SInt(32.W))
	val out_rs2=Output(SInt(32.W))
})
	val registers=Reg(Vec(32,SInt(32.W)))
	registers(0):=0.S
	io.out_rs1:=registers(io.in_rs1)
	io.out_rs2:=registers(io.in_rs2)
	when(io.in_regwrite==="b1".U){	
		when(io.in_rd==="b00000".U){
			registers(io.in_rd):=0.S
		}.otherwise{
			registers(io.in_rd):=io.in_writedata
		}
	}
}
