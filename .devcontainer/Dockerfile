# Use Microsoft's official Java 21 devcontainer base image
FROM mcr.microsoft.com/devcontainers/java:21

# Install additional tools
RUN apt-get update \
    && apt-get -y install --no-install-recommends \
    curl \
    wget \
    git \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /workspace

# Keep container running
CMD ["sleep", "infinity"]
