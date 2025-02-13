import React from 'react';
import {
  StyledButtonContainer,
  StyledContainer,
  StyledIconContainer,
  StyledLogo,
  StyledMetamaskLogo,
} from './styles';
import {MainButton} from '../../components';
import {Assets} from '../../assets/images';
import {useMetaMask} from '../../hooks/useMetamask';

export const Login = () => {
  const {connectWallet} = useMetaMask();

  return (
    <StyledContainer>
      <StyledIconContainer>
        <StyledLogo source={Assets.logo} />
      </StyledIconContainer>
      <StyledButtonContainer>
        <MainButton
          label="Connect with Metamask"
          backgroundColor="secondaryColorLight"
          onPress={connectWallet}
          rightIcon={<StyledMetamaskLogo source={Assets.metamaskLogo} />}
        />
      </StyledButtonContainer>
    </StyledContainer>
  );
};
