package riscv
import chisel3._
import chisel3.util.Cat
import chisel3.core.SInt
import chisel3.util.Fill
class Immediategeneration extends Module{
	val io=IO(new Bundle{
		val instruction=Input(UInt(32.W))
		val pc=Input(UInt(32.W))
		val sb_type=Output(SInt(32.W))
		val s_type=Output(SInt(32.W))
		val u_type=Output(SInt(32.W))
		val uj_type=Output(SInt(32.W))			
		val i_type=Output(SInt(32.W))
})
	//Sb Type
	val sb_11th=io.instruction(7)
	val sb_lower=io.instruction(11,8)
	val sb_upper=io.instruction(30,25)
	val sb_12th=io.instruction(31)
	val sb_imm_13=Cat(sb_12th,sb_11th,sb_upper,sb_lower,0.S)
	val sb_imm_32=Cat(Fill(19,sb_imm_13(12)),sb_imm_13).asSInt
	io.sb_type:= io.pc.asSInt+sb_imm_32
	//S type
	val s_lower=io.instruction(11,7)
	val s_upper=io.instruction(31,25)
	val s_imm_12=Cat(s_upper,s_lower)
	io.s_type:=Cat(Fill(20,s_imm_12(11)),s_imm_12).asSInt		
	//I Type
	val i_imm_12=io.instruction(31,20)
	val i_imm_32=Cat(Fill(20,i_imm_12(11)),i_imm_12)
	io.i_type:=i_imm_32.asSInt
	//U Type
	val u_imm_20=io.instruction(31,12)
	val u_imm_32=Cat(Fill(12,u_imm_20(19)),u_imm_20).asSInt
	val u_imm_32l=u_imm_32<<12.U
	io.u_type:=u_imm_32l.asSInt
	//UJ type
	val uj_mid=io.instruction(19,12)
	val uj_11th=io.instruction(20)
	val uj_lower=io.instruction(30,21)
	val uj_20th=io.instruction(31)
	val uj_imm_21=Cat(uj_20th,uj_mid,uj_11th,uj_lower,0.S)
	val uj_imm_32=Cat(Fill(10,uj_imm_21(20)),uj_imm_21).asSInt
	io.uj_type:=io.pc.asSInt+uj_imm_32
}

