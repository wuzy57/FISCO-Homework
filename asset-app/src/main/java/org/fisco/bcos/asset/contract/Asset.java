package org.fisco.bcos.asset.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Asset extends Contract {
    public static String BINARY = "60806040523480156200001157600080fd5b506200002b62000031640100000000026401000000009004565b6200018c565b600061100190508073ffffffffffffffffffffffffffffffffffffffff166356004b6a6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018060200180602001848103845260078152602001807f745f617373657400000000000000000000000000000000000000000000000000815250602001848103835260078152602001807f6163636f756e74000000000000000000000000000000000000000000000000008152506020018481038252600b8152602001807f61737365745f76616c75650000000000000000000000000000000000000000008152506020019350505050602060405180830381600087803b1580156200014b57600080fd5b505af115801562000160573d6000803e3d6000fd5b505050506040513d60208110156200017757600080fd5b81019080805190602001909291905050505050565b6123ee806200019c6000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806351160630146100675780639b80b05014610092578063ea87152b1461015f578063fcd7e3c1146101e6575b600080fd5b34801561007357600080fd5b5061007c61026a565b6040518082815260200191505060405180910390f35b34801561009e57600080fd5b50610149600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001909291905050506107e2565b6040518082815260200191505060405180910390f35b34801561016b57600080fd5b506101d0600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929080359060200190929190505050611876565b6040518082815260200191505060405180910390f35b3480156101f257600080fd5b5061024d600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611dc4565b604051808381526020018281526020019250505060405180910390f35b60008060008061027861222e565b9250600091505b6000805490508210156107a0578273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156102f057600080fd5b505af1158015610304573d6000803e3d6000fd5b505050506040513d602081101561031a57600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663e942b51660008481548110151561035857fe5b906000526020600020016040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260078152602001807f6163636f756e740000000000000000000000000000000000000000000000000081525060200183810382528481815460018160011615610100020316600290048152602001915080546001816001161561010002031660029004801561044e5780601f106104235761010080835404028352916020019161044e565b820191906000526020600020905b81548152906001019060200180831161043157829003601f168201915b50509350505050600060405180830381600087803b15801561046f57600080fd5b505af1158015610483573d6000803e3d6000fd5b505050508073ffffffffffffffffffffffffffffffffffffffff16632ef8ba7460006040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018381526020018281038252600b8152602001807f61737365745f76616c756500000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b15801561053057600080fd5b505af1158015610544573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff1663bf2b70a160008481548110151561057357fe5b90600052602060002001838673ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156105e257600080fd5b505af11580156105f6573d6000803e3d6000fd5b505050506040513d602081101561060c57600080fd5b81019080805190602001909291905050506040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281038252858181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156107355780601f1061070a57610100808354040283529160200191610735565b820191906000526020600020905b81548152906001019060200180831161071857829003601f168201915b5050945050505050602060405180830381600087803b15801561075757600080fd5b505af115801561076b573d6000803e3d6000fd5b505050506040513d602081101561078157600080fd5b810190808051906020019092919050505050818060010192505061027f565b7fe52aa7342eb68231147c9ade67e21ba8108f3def0d92c4f501c9c8953b761c8260006040518082815260200191505060405180910390a16000935050505090565b60008060008060008060008060008097506000965060009550600094506108088c611dc4565b8097508198505050600087141515610943577fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff9750898b6040518082805190602001908083835b602083101515610874578051825260208201915060208101905060208303925061084f565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b6020831015156108d757805182526020820191506020810190506020830392506108b2565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a4879850611867565b61094c8b611dc4565b8096508198505050600087141515610a87577ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe9750898b6040518082805190602001908083835b6020831015156109b85780518252602082019150602081019050602083039250610993565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b602083101515610a1b57805182526020820191506020810190506020830392506109f6565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a4879850611867565b89861015610bb8577ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffd9750898b6040518082805190602001908083835b602083101515610ae95780518252602082019150602081019050602083039250610ac4565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b602083101515610b4c5780518252602082019150602081019050602083039250610b27565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a4879850611867565b848a86011015610ceb577ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffc9750898b6040518082805190602001908083835b602083101515610c1c5780518252602082019150602081019050602083039250610bf7565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b602083101515610c7f5780518252602082019150602081019050602083039250610c5a565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a4879850611867565b610cf361222e565b93508373ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610d5957600080fd5b505af1158015610d6d573d6000803e3d6000fd5b505050506040513d6020811015610d8357600080fd5b810190808051906020019092919050505092508273ffffffffffffffffffffffffffffffffffffffff1663e942b5168d6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260078152602001807f6163636f756e7400000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015610e56578082015181840152602081019050610e3b565b50505050905090810190601f168015610e835780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610ea357600080fd5b505af1158015610eb7573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff16632ef8ba748b88036040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018381526020018281038252600b8152602001807f61737365745f76616c756500000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b158015610f6557600080fd5b505af1158015610f79573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff1663bf2b70a18d858773ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610fff57600080fd5b505af1158015611013573d6000803e3d6000fd5b505050506040513d602081101561102957600080fd5b81019080805190602001909291905050506040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b838110156111095780820151818401526020810190506110ee565b50505050905090810190601f1680156111365780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b15801561115757600080fd5b505af115801561116b573d6000803e3d6000fd5b505050506040513d602081101561118157600080fd5b810190808051906020019092919050505091506001821415156112c7577ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffb9750898b6040518082805190602001908083835b6020831015156111f857805182526020820191506020810190506020830392506111d3565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b60208310151561125b5780518252602082019150602081019050602083039250611236565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a4879850611867565b8373ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561132b57600080fd5b505af115801561133f573d6000803e3d6000fd5b505050506040513d602081101561135557600080fd5b810190808051906020019092919050505090508073ffffffffffffffffffffffffffffffffffffffff1663e942b5168c6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260078152602001807f6163636f756e7400000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b8381101561142857808201518184015260208101905061140d565b50505050905090810190601f1680156114555780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561147557600080fd5b505af1158015611489573d6000803e3d6000fd5b505050508073ffffffffffffffffffffffffffffffffffffffff16632ef8ba748b87016040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018381526020018281038252600b8152602001807f61737365745f76616c756500000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b15801561153757600080fd5b505af115801561154b573d6000803e3d6000fd5b505050508373ffffffffffffffffffffffffffffffffffffffff1663bf2b70a18c838773ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b1580156115d157600080fd5b505af11580156115e5573d6000803e3d6000fd5b505050506040513d60208110156115fb57600080fd5b81019080805190602001909291905050506040518463ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b838110156116db5780820151818401526020810190506116c0565b50505050905090810190601f1680156117085780820380516001836020036101000a031916815260200191505b50945050505050602060405180830381600087803b15801561172957600080fd5b505af115801561173d573d6000803e3d6000fd5b505050506040513d602081101561175357600080fd5b810190808051906020019092919050505050898b6040518082805190602001908083835b60208310151561179c5780518252602082019150602081019050602083039250611777565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390208d6040518082805190602001908083835b6020831015156117ff57805182526020820191506020810190506020830392506117da565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f8f6b9fa4d4bf04c7c1c3242d4a5c59ba22525b6761cf89e44becb27c606154bd8b6040518082815260200191505060405180910390a48798505b50505050505050509392505050565b6000806000806000806000809550600094506000935061189589611dc4565b8095508196505050600085141515611cf65760008990806001815401808255809150509060018203906000526020600020016000909192909190915090805190602001906118e492919061231d565b50506118ee61222e565b92508273ffffffffffffffffffffffffffffffffffffffff166313db93466040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561195457600080fd5b505af1158015611968573d6000803e3d6000fd5b505050506040513d602081101561197e57600080fd5b810190808051906020019092919050505091508173ffffffffffffffffffffffffffffffffffffffff1663e942b5168a6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835260078152602001807f6163636f756e7400000000000000000000000000000000000000000000000000815250602001838103825284818151815260200191508051906020019080838360005b83811015611a51578082015181840152602081019050611a36565b50505050905090810190601f168015611a7e5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015611a9e57600080fd5b505af1158015611ab2573d6000803e3d6000fd5b505050508173ffffffffffffffffffffffffffffffffffffffff16632ef8ba74896040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018381526020018281038252600b8152602001807f61737365745f76616c756500000000000000000000000000000000000000000081525060200192505050600060405180830381600087803b158015611b5e57600080fd5b505af1158015611b72573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff166331afac368a846040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015611c31578082015181840152602081019050611c16565b50505050905090810190601f168015611c5e5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015611c7e57600080fd5b505af1158015611c92573d6000803e3d6000fd5b505050506040513d6020811015611ca857600080fd5b810190808051906020019092919050505090506001811415611ccd5760009550611cf1565b7ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe95505b611d1a565b7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff95505b87896040518082805190602001908083835b602083101515611d515780518252602082019150602081019050602083039250611d2c565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390207f91c95f04198617c60eaf2180fbca88fc192db379657df0e412a9f7dd4ebbe95d886040518082815260200191505060405180910390a385965050505050505092915050565b600080600080600080611dd561222e565b93508373ffffffffffffffffffffffffffffffffffffffff1663e8434e39888673ffffffffffffffffffffffffffffffffffffffff16637857d7c96040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015611e5857600080fd5b505af1158015611e6c573d6000803e3d6000fd5b505050506040513d6020811015611e8257600080fd5b81019080805190602001909291905050506040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825284818151815260200191508051906020019080838360005b83811015611f30578082015181840152602081019050611f15565b50505050905090810190601f168015611f5d5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b158015611f7d57600080fd5b505af1158015611f91573d6000803e3d6000fd5b505050506040513d6020811015611fa757600080fd5b81019080805190602001909291905050509250600091508273ffffffffffffffffffffffffffffffffffffffff1663949d225d6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561202257600080fd5b505af1158015612036573d6000803e3d6000fd5b505050506040513d602081101561204c57600080fd5b810190808051906020019092919050505060001415612093577fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8281915095509550612225565b8273ffffffffffffffffffffffffffffffffffffffff1663846719e060006040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b15801561210357600080fd5b505af1158015612117573d6000803e3d6000fd5b505050506040513d602081101561212d57600080fd5b8101908080519060200190929190505050905060008173ffffffffffffffffffffffffffffffffffffffff1663fda69fae6040518163ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180806020018281038252600b8152602001807f61737365745f76616c7565000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b1580156121e257600080fd5b505af11580156121f6573d6000803e3d6000fd5b505050506040513d602081101561220c57600080fd5b8101908080519060200190929190505050819150955095505b50505050915091565b600080600061100191508173ffffffffffffffffffffffffffffffffffffffff1663f23f63c96040518163ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825260078152602001807f745f617373657400000000000000000000000000000000000000000000000000815250602001915050602060405180830381600087803b1580156122d857600080fd5b505af11580156122ec573d6000803e3d6000fd5b505050506040513d602081101561230257600080fd5b81019080805190602001909291905050509050809250505090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061235e57805160ff191683800117855561238c565b8280016001018555821561238c579182015b8281111561238b578251825591602001919060010190612370565b5b509050612399919061239d565b5090565b6123bf91905b808211156123bb5760008160009055506001016123a3565b5090565b905600a165627a7a72305820ad252db1894e751eb687e2bbb466598d7634a97d26e4f451248a6f5f311d3ed00029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[],\"name\":\"settlement\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"from_account\",\"type\":\"string\"},{\"name\":\"to_account\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"transfer\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"account\",\"type\":\"string\"},{\"name\":\"asset_value\",\"type\":\"uint256\"}],\"name\":\"register\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"account\",\"type\":\"string\"}],\"name\":\"select\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"},{\"indexed\":true,\"name\":\"account\",\"type\":\"string\"},{\"indexed\":true,\"name\":\"asset_value\",\"type\":\"uint256\"}],\"name\":\"RegisterEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"},{\"indexed\":true,\"name\":\"from_account\",\"type\":\"string\"},{\"indexed\":true,\"name\":\"to_account\",\"type\":\"string\"},{\"indexed\":true,\"name\":\"amount\",\"type\":\"uint256\"}],\"name\":\"TransferEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ret\",\"type\":\"int256\"}],\"name\":\"SettlementEvent\",\"type\":\"event\"}]";

    public static final String FUNC_SETTLEMENT = "settlement";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_REGISTER = "register";

    public static final String FUNC_SELECT = "select";

    public static final Event REGISTEREVENT_EVENT = new Event("RegisterEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event TRANSFEREVENT_EVENT = new Event("TransferEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Utf8String>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event SETTLEMENTEVENT_EVENT = new Event("SettlementEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected Asset(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Asset(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Asset(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Asset(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> settlement() {
        final Function function = new Function(
                FUNC_SETTLEMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void settlement(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTLEMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String settlementSeq() {
        final Function function = new Function(
                FUNC_SETTLEMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> transfer(String from_account, String to_account, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(from_account), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(to_account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void transfer(String from_account, String to_account, BigInteger amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(from_account), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(to_account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String transferSeq(String from_account, String to_account, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(from_account), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(to_account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> register(String account, BigInteger asset_value) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(asset_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void register(String account, BigInteger asset_value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(asset_value)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registerSeq(String account, BigInteger asset_value) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(account), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(asset_value)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> select(String account) {
        final Function function = new Function(FUNC_SELECT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public List<RegisterEventEventResponse> getRegisterEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REGISTEREVENT_EVENT, transactionReceipt);
        ArrayList<RegisterEventEventResponse> responses = new ArrayList<RegisterEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RegisterEventEventResponse typedResponse = new RegisterEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.asset_value = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.ret = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerRegisterEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REGISTEREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerRegisterEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(REGISTEREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<TransferEventEventResponse> getTransferEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFEREVENT_EVENT, transactionReceipt);
        ArrayList<TransferEventEventResponse> responses = new ArrayList<TransferEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventEventResponse typedResponse = new TransferEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from_account = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to_account = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.ret = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerTransferEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TRANSFEREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerTransferEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TRANSFEREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<SettlementEventEventResponse> getSettlementEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETTLEMENTEVENT_EVENT, transactionReceipt);
        ArrayList<SettlementEventEventResponse> responses = new ArrayList<SettlementEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SettlementEventEventResponse typedResponse = new SettlementEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ret = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerSettlementEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETTLEMENTEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerSettlementEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETTLEMENTEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static Asset load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Asset(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Asset load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Asset(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Asset load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Asset(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Asset load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Asset(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Asset> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Asset.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Asset> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Asset.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Asset> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Asset.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Asset> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Asset.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class RegisterEventEventResponse {
        public Log log;

        public byte[] account;

        public BigInteger asset_value;

        public BigInteger ret;
    }

    public static class TransferEventEventResponse {
        public Log log;

        public byte[] from_account;

        public byte[] to_account;

        public BigInteger amount;

        public BigInteger ret;
    }

    public static class SettlementEventEventResponse {
        public Log log;

        public BigInteger ret;
    }
}
