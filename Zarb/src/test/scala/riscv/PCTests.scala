package riscv
import chisel3.iotesters.PeekPokeTester
class PCTests(c:PC) extends PeekPokeTester(c){
		poke(c.io.input,4)
		step(1)
}
