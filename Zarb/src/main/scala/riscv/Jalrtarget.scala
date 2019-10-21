package riscv
import chisel3._
class Jalrtarget extends Module{
val io=IO(new Bundle{
	val in_rs1out=Input(SInt(32.W))
	val in_immed=Input(SInt(32.W))
	val outjalr=Output(SInt(32.W))
})
	val addition=io.in_rs1out+io.in_immed
	io.outjalr:=addition&4294967294L.S
}
