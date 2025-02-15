import {Assets} from '../../assets/images';
import {
  ConnectedText,
  StyledMetamaskLogo,
  TopBar,
  TopBarLeftSide,
  TopBarRightSide,
  WalletText,
} from './styles';

export const TopBarComponent = () => {
  return (
    <TopBar>
      <TopBarLeftSide>
        <StyledMetamaskLogo source={Assets.metamaskLogo} />
      </TopBarLeftSide>
      {/* <Text>{walletAddress}</Text> */}
      <TopBarRightSide>
        <ConnectedText>You are connected</ConnectedText>
        <WalletText>1r2xxcnjhvbsdvad12...</WalletText>
      </TopBarRightSide>
    </TopBar>
  );
};
